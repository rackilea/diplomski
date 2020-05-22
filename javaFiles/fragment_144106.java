// expect a positiv result
boolean result = true;
// calculate first line
int firstLine = rowSum(m[0]);

// loop remaining lines
for (int i = 1 ; i < m.length ; i++){
    // compare first line with current line
    if (firstLine != rowSum(m[i]))
    {
       // not equal -> change result 
       result = false;
       // break loop
       break;
    }   
}
return result;