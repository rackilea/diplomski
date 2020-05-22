//declaring global variable
ArrayList<Long> vectorTime;                         //before
ArrayList<Long> vectorTime = new ArrayList<Long>(); //after

//inside CreatingArray()
ArrayList<Long> tm = new ArrayList<Long>(); //before
vectorTime.clear();                         //after

//inside getWsize
long SumSamp1 = timestamp.get(0); //before
long SumSamp1 = vectorTime.get(0);//after