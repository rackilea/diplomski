TOKEN:
{
    < INT_VALUE: (<DIGIT>)+ >
    | < FLOAT_VALUE: <INT_VALUE> "." (<DIGIT>)* | "." (<DIGIT>)+ >
    | < CHAR_VALUE: "\'" (~["\'","\\"]|<ESCAPE>) "\'" >
    | < STRING_VALUE: "\"" (~["\'","\\"]|<ESCAPE>)* "\"" >
    | < #ESCAPE: "\\" ["n","t","b","r","f","\\","\"","\'"] >
}