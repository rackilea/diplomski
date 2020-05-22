@(aziende: List[crudder.models.Persistent], editForm: Form[Azienda],id:Long)

@import helper._
@import crudder.viewhelpers.html.bootstrap.f
@Field = @{ FieldConstructor(crudder.viewhelpers.html.bootstrap.f) }

@editFields() = {

    @inputText(editForm("descrizione"), '_label -> "Ragione sociale")(Field,null)
}

@main("Amministrazione - Aziende") {
<!--This one use my customized block-->
@inputText(editForm("descrizione"), '_label -> "Ragione sociale")
<!--Now this work too!-->
@editFields()

}