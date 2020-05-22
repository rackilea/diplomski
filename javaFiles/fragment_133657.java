// !!! DO NOT EDIT!!! 
// Code generated from grammar ToyLang by antlr4scala
// 

 // scala listener header
 package toylang.parser.antlr
 import toylang.ast._
 import scala.collection.JavaConversions._


class  Listener extends ToyLangBaseListener {

     // scala listener members
     // stores the result of a successfull parse
     var result: Option[List[Stmt]] = None 


    override def enterDefStmtRule( ctx: ToyLangParser.DefStmtRuleContext ): Unit = {
         // entry action for alternative
         println("About to parse a statement!")

    }


    override def exitProgramRule( ctx: ToyLangParser.ProgramRuleContext ): Unit = {
         // exitAction for alternative
         ctx.result = (ctx.sl.view  map { _.result }).toList
         result = Some(ctx.result)
    }


    override def exitIntType( ctx: ToyLangParser.IntTypeContext ): Unit = {
         ctx.result = IntType
    }


    override def exitBoolType( ctx: ToyLangParser.BoolTypeContext ): Unit = {
         ctx.result = BoolType
    }


    override def exitDefStmtRule( ctx: ToyLangParser.DefStmtRuleContext ): Unit = {
         // exit action for alternative
         val d = ctx.d match {
           case null => None
           case e@_ => Some(e.result)
         }
         ctx.result = DefStmt(ctx.id.result, ctx.t.result, d)
    }


    override def exitDefRule( ctx: ToyLangParser.DefRuleContext ): Unit = {
         ctx.result = ctx.e.result
    }


    override def exitBoolNumExpr( ctx: ToyLangParser.BoolNumExprContext ): Unit = {
            ctx.result = ctx.e.result
    }


    override def exitIntNumxpr( ctx: ToyLangParser.IntNumxprContext ): Unit = {
            ctx.result = ctx.e.result
    }


    override def exitIdentExpr( ctx: ToyLangParser.IdentExprContext ): Unit = {
            ctx.result = ctx.e.result
    }


    override def exitParenExpr( ctx: ToyLangParser.ParenExprContext ): Unit = {
            ctx.result = ctx.e.result
    }


    override def exitUnopArithExpr( ctx: ToyLangParser.UnopArithExprContext ): Unit = {
         import ToyLangParser.{ADD, SUB}
          val op = ctx.op.getType match {
          case ADD => Plus
          case SUB => Minus
         }
         ctx.result = op(ctx.e.result)
    }


    override def exitPowerExpr( ctx: ToyLangParser.PowerExprContext ): Unit = {
         ctx.result = Pow(ctx.l.result, ctx.r.result)
    }


    override def exitMulDivExpr( ctx: ToyLangParser.MulDivExprContext ): Unit = {
         import ToyLangParser.{STAR, SLASH}
          val op = ctx.op.getType match {
          case STAR => Mul
          case SLASH => Div
         }
         ctx.result = op(ctx.l.result, ctx.r.result) 
    }


    override def exitAddSubExpr( ctx: ToyLangParser.AddSubExprContext ): Unit = {
         import ToyLangParser.{ADD, SUB}
          val op = ctx.op.getType match {
          case ADD => Add
          case SUB => Sub
         }
         ctx.result = op(ctx.l.result, ctx.r.result) 
    }


    override def exitRelExpr( ctx: ToyLangParser.RelExprContext ): Unit = {
         import ToyLangParser.{NEQ,EQ,LT,LE,GT,GE}
          val op = ctx.op.getType match {
          case NEQ => Neq
          case EQ => Eq
          case LT => Lt
          case GT => Gt
          case LE => Le
          case GE => Ge
         }
         ctx.result = op(ctx.l.result, ctx.r.result) 
    }


    override def exitNotExpr( ctx: ToyLangParser.NotExprContext ): Unit = {
         ctx.result = Not(ctx.e.result)
    }


    override def exitAndExpr( ctx: ToyLangParser.AndExprContext ): Unit = {
         ctx.result = And(ctx.l.result, ctx.r.result)
    }


    override def exitOrExpr( ctx: ToyLangParser.OrExprContext ): Unit = {
         ctx.result = Or(ctx.l.result, ctx.r.result)
    }


    override def exitImpliesExpr( ctx: ToyLangParser.ImpliesExprContext ): Unit = {
         ctx.result = Implies(ctx.l.result, ctx.r.result)
    }


    override def exitIteExpr( ctx: ToyLangParser.IteExprContext ): Unit = {
         val elsifList = ctx.ei.view  map { _.result } 
         ctx.result = Ite(ctx.c.result, 
                          ctx.t.result, 
                          elsifList.toList, 
                          ctx.e.result)
    }


    override def exitElsifRule( ctx: ToyLangParser.ElsifRuleContext ): Unit = {
         ctx.result = Elsif(ctx.c.result, ctx.t.result)
    }


    override def exitIdentRule( ctx: ToyLangParser.IdentRuleContext ): Unit = {
         ctx.result = Ident(ctx.id.getText)
    }


    override def exitIntNumRule( ctx: ToyLangParser.IntNumRuleContext ): Unit = {
         ctx.result = IntNum(ctx.num.getText)
    }


    override def exitBoolNumRule( ctx: ToyLangParser.BoolNumRuleContext ): Unit = {
         ctx.result = BoolNum(ctx.num.getText)
    }


}