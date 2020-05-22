options {
    STATIC = false;
    OUTPUT_DIRECTORY = "src/parser";
}
PARSER_BEGIN(Parser)
package parser;
public class Parser {
    public void parse() throws ParseException {
        input();
    }
}
PARSER_END(Parser)

SKIP :
{
< " " | "\t" | "\r" | "\n" | "\r\n" >
| <"//" (~["\n","\r"])* ("\n"|"\r"|"\r\n") >
| <"/*"(~["/"])*  "*""/" >
}
TOKEN : { < VAR: "VAR" > }
TOKEN : { < AS: "AS" >}
TOKEN : { < START: "START" > | < STOP: "STOP" > | < OUTPUT: "OUTPUT" > } 
TOKEN : /* KEYWORDS */
{
    <INT: "INT">|<BOOL:"BOOL">|<FLOAT:"FLOAT">|<CHAR:"CHAR">
    |<AND: "AND"> | <OR: "OR"> | <NOT: "NOT">
}

TOKEN :
{
  < EQUALS: "=" > | < COLON: ":" > | <LPAR: "(">|<RPAR: ")">
}
TOKEN:
{
  < PLUS : "+" >|< MINUS :"-" >|< MUL: "*" >|< DIV: "/" >|< MOD: "%" >|< COMM: ",">
  |<LT: "<">|<GT: ">">|<LE: "<=">|<GE: ">=">|<EQ: "==">|<NE: "<>">
  |<CAT: "&">
}
TOKEN:
{
    < VARIABLE: <LETTER>(<LETTER>|<DIGIT>)* >
    | < #LETTER: ["a"-"z", "A"-"Z", "_"] >
    | < #DIGIT: ["0"-"9"] >
}
TOKEN:
{
    < INT_VALUE: (<DIGIT>)+ >
    | < FLOAT_VALUE: <INT_VALUE> "." (<DIGIT>)* | "." (<DIGIT>)+ >
    | < CHAR_VALUE: "\'" (~["\'","\\"]|<ESCAPE>) "\'" >
    | < STRING_VALUE: "\"" (~["\"","\\"]|<ESCAPE>)* "\"" >
    | < #ESCAPE: "\\" ["n","t","b","r","f","\\","\"","\'"] >
}

void input(): {} { (declaration())*  body() }
void varDeclaration(): {} { <VARIABLE> (<EQUALS> literalValue())?  }
void literalValue(): {} { <INT_VALUE> | <FLOAT_VALUE> | <CHAR_VALUE> | <STRING_VALUE> }
void declaration(): {} { <VAR> varDeclaration() (<COMM> varDeclaration())* <AS> type()}
void type(): {} {<INT>|<FLOAT>|<BOOL>|<CHAR>}
void body(): {} { <START> (statement())* <STOP> }
void statement(): {} { assignment() | output() }
void assignment(): {} { <VARIABLE> <EQUALS> expression() }
void output(): {} { <OUTPUT> <COLON> expression() }
void expression(): {} { comparison() (logicalOp() comparison())* }
void logicalOp(): {} { <AND> | <OR> }
void comparison(): {} { simpleExpression() ( comparisonOp() simpleExpression() )? }
void comparisonOp(): {} { <LT> | <GT> | <LE> | <GE> | <EQ> | <NE> }
void simpleExpression(): {} { term() ( addOp() term() )* }
void addOp(): {} { <PLUS> | <MINUS> | <CAT> }
void term(): {} { factor() ( mulOp() factor() )* }
void mulOp(): {} { <MUL> | <DIV> | <MOD> }
void factor(): {} {
    (<PLUS>|<MINUS>) factor()
    | <LPAR> expression() <RPAR>
    | <NOT> expression()
    | <VARIABLE>
    | literalValue()
}