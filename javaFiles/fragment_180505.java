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
TOKEN : /* KEYWORDS */
{
    < TYPE: "INT" | "BOOL" | "FLOAT" | "CHAR" >
}

TOKEN :
{
  < EQUALS: "=" >
}
TOKEN:
{
  < PLUS : "+" >|< MINUS :"-" >|< MUL: "*" >|< DIV: "/" >|< COMM: ",">
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
    | < STRING_VALUE: "\"" (~["\'","\\"]|<ESCAPE>)* "\"" >
    | < #ESCAPE: "\\" ["n","t","b","r","f","\\","\"","\'"] >
}

void input(): {} { (declaration())* }
void varDeclaration(): {} { <VARIABLE> (<EQUALS> literalValue())? }
void literalValue(): {} { <INT_VALUE> | <FLOAT_VALUE> | <CHAR_VALUE> | <STRING_VALUE> }
void declaration(): {} { <VAR> varDeclaration() (< COMM > varDeclaration())* <AS> <TYPE>}