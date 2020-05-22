TextView t = null;
switch(value){
   case VALUEA:
        setContentView(R.layout.valuealayout);
        t = (TextView) findViewById(R.id.valuealayout);
        t.findViewById(R.id.valuealayout);
        break;
   case VALUEB:
        setContentView(R.layout.valueblayout);
        t = (TextView) findViewById(R.id.valueblayout);
        t.findViewById(R.id.valueblayout);
        break;
   case VALUEC:
        setContentView(R.layout.valueclayout);
        t = (TextView) findViewById(R.id.valueclayout);
        t.findViewById(R.id.valueclayout);
        break;
   default:
        break;
}