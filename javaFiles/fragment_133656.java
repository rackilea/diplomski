//! // scala listener header
//! package toylang.parser.antlr
//! import toylang.ast._
//! import scala.collection.JavaConversions._

grammar ToyLang;

@lexer::header{
package toylang.parser.antlr;
}

@parser::header{
package toylang.parser.antlr;
import toylang.ast.*; // import scala ast symbols
}

//! // scala listener members
//! // stores the result of a successfull parse
//! var result: Option[List[Stmt]] = None 

program 
locals [scala.collection.immutable.List<Stmt> result]
    : sl+=defStmt sl+=defStmt* EOF # ProgramRule
        //! // exitAction for alternative
        //! ctx.result = (ctx.sl.view  map { _.result }).toList
        //! result = Some(ctx.result)

    ;

type 
locals [TypeExpr result]
    : 'int'  # IntType
        //! ctx.result = IntType
    | 'bool' # BoolType
        //! ctx.result = BoolType
    ;

defStmt 
locals[Stmt result]
    : 
        //! // entry action for alternative
        //! println("About to parse a statement!")
        //!
        id=ident ':' t=type  d=def? ';' # DefStmtRule
        //! // exit action for alternative
        //! val d = ctx.d match {
        //!   case null => None
        //!   case e@_ => Some(e.result)
        //! }
        //! ctx.result = DefStmt(ctx.id.result, ctx.t.result, d)
    ; 

def
locals [Expr result]
    : op=DEFINE e=expr  # DefRule
        //! ctx.result = ctx.e.result
    ;

expr 
locals[Expr result]
    : e=boolNum  # BoolNumExpr
        //! ctx.result = ctx.e.result

    | e=intNum   # IntNumxpr
        //! ctx.result = ctx.e.result

    | e=ident    # IdentExpr
        //! ctx.result = ctx.e.result

    | op='(' e=expr ')' # ParenExpr
        //! ctx.result = ctx.e.result

    | op=(ADD|SUB) e=expr # UnopArithExpr
        //! import ToyLangParser.{ADD, SUB}
        //!  val op = ctx.op.getType match {
        //!  case ADD => Plus
        //!  case SUB => Minus
        //! }
        //! ctx.result = op(ctx.e.result)

    |<assoc=right> l=expr op=CARRET r=expr  # PowerExpr
        //! ctx.result = Pow(ctx.l.result, ctx.r.result)

    |<assoc=left> l=expr op=(STAR|SLASH) r=expr # MulDivExpr
        //! import ToyLangParser.{STAR, SLASH}
        //!  val op = ctx.op.getType match {
        //!  case STAR => Mul
        //!  case SLASH => Div
        //! }
        //! ctx.result = op(ctx.l.result, ctx.r.result) 

    |<assoc=left> l=expr op=(ADD|SUB) r=expr # AddSubExpr
        //! import ToyLangParser.{ADD, SUB}
        //!  val op = ctx.op.getType match {
        //!  case ADD => Add
        //!  case SUB => Sub
        //! }
        //! ctx.result = op(ctx.l.result, ctx.r.result) 

    | l=expr op=(NEQ|EQ|LT|LE|GT|GE) r=expr # RelExpr
        //! import ToyLangParser.{NEQ,EQ,LT,LE,GT,GE}
        //!  val op = ctx.op.getType match {
        //!  case NEQ => Neq
        //!  case EQ => Eq
        //!  case LT => Lt
        //!  case GT => Gt
        //!  case LE => Le
        //!  case GE => Ge
        //! }
        //! ctx.result = op(ctx.l.result, ctx.r.result) 

    | op=NOT e=expr   # NotExpr
        //! ctx.result = Not(ctx.e.result)

    |<assoc=left> l=expr op=AND r=expr # AndExpr
        //! ctx.result = And(ctx.l.result, ctx.r.result)

    |<assoc=left> l=expr op=OR r=expr  # OrExpr
        //! ctx.result = Or(ctx.l.result, ctx.r.result)

    |<assoc=left> l=expr op=IMPLIES r=expr # ImpliesExpr
        //! ctx.result = Implies(ctx.l.result, ctx.r.result)

    | IF c=expr THEN t=expr ei+=elsif* ELSE e=expr  # IteExpr
        //! val elsifList = ctx.ei.view  map { _.result } 
        //! ctx.result = Ite(ctx.c.result, 
        //!                  ctx.t.result, 
        //!                  elsifList.toList, 
        //!                  ctx.e.result)
   ;

elsif 
locals [Elsif result]
    : op=ELSIF c=expr THEN t=expr # ElsifRule
        //! ctx.result = Elsif(ctx.c.result, ctx.t.result)
    ;

ident
locals [Ident result]
    : id=IDENT # IdentRule
        //! ctx.result = Ident(ctx.id.getText)
    ;

intNum
locals [IntNum result]
    : num=INT_NUM # IntNumRule
        //! ctx.result = IntNum(ctx.num.getText)
    ;

boolNum
locals [BoolNum result]
    : num=(TRUE | FALSE) # BoolNumRule
        //! ctx.result = BoolNum(ctx.num.getText)

    ;

COMMENT: (EOL | MLC) -> skip ;
fragment MLC: '/*' ( COMMENT | . )*? '*/' ;
fragment EOL: '//' .*? '\n' ;

LT: '<' ;
LE: '<=' ;
GT: '>' ;
GE: '>=' ;
EQ: '=' ;
NEQ: '!=' ;
ADD: '+';
AND: 'and';
DEFINE: ':=';
CARRET: '^';
ELSE: 'else';
ELSIF: 'elsif';
FALSE: 'false';
IF: 'if';
IMPLIES: 'implies';
KW_BOOL: 'bool';
KW_INT: 'int';
NOT: 'not';
OR: 'or';
SLASH: '*';
STAR: '*';
SUB: '-';
THEN: 'then';
TRUE: 'true';
INT_NUM :'0' |[1-9][0-9]* ; 
IDENT:[_a-zA-Z][_a-zA-Z0-9]* ;
WS: [ \t\f\r\n]+ -> skip;