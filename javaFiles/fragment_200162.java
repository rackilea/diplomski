<*> SKIP: { " " }

<S0> TOKEN: { <STATE: "state"> : S1 }

<DEFAULT> TOKEN:{ <PROD_NAME: (["a"-"z"])+ >  : S0 }
<S0,S1> TOKEN:{ <PROD_NAME: (["a"-"z"])+ >  }

<S1> TOKEN: { <SEMICOLON : ";" > : DEFAULT
<S0, DEFAULT> TOKEN : { <SEMICOLON : ";" > }

<*> TOKEN {
     COLON : ":"
|    ...etc...
}