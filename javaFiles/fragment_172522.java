import scala.reflect.macros._
import scala.annotation.StaticAnnotation
import scala.language.experimental.macros

class JsonSerializeARGB extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro JsonSerializeARGBMacroImpl.impl
}

object JsonSerializeARGBMacroImpl extends JsonSerializeARGBMacro

class JsonSerializeARGBMacro {
  def impl(c: Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
      import c.universe._

      def modifiedDef(d: DefDef) = {
        val (mods, name, tparams, paramss, tpt, body) = try {
          val q"$mods def $name[..$tparams](...$paramss): $tpt = $body" = d
          (mods, name, tparams, paramss, tpt, body)
        } catch {
          case _: MatchError => c.abort(c.enclosingPosition, "Failed to match...")
        }

        //TODO there is a problem with modifiers
        c.Expr(q"""
          @JsonSerialize(using = classOf[CustomColorRGBASerializer])
          def $name[..$tparams](...$paramss): $tpt = $body
          """)
      }

      annottees.map(_.tree) match {
        case (d: DefDef) :: Nil => modifiedDef(d)
        case _ => c.abort(c.enclosingPosition, "Invalid annottee.")
      }
    }
 }