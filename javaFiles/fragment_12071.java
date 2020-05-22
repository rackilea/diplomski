float temp ;
/*Here you are just setting up the value
 * the method is not returning anything so
 * it should be called like this obj.setTemperature(20.0);
 */
void setTemperature(float newTemp) 
{ 
   temp = newTemp; 
}

/*Here you are retrieving the value thats why
 * While calling you should store the result
 * in a variable like this: float num= obj.getTemperature();
 */
float getTemperature() 
{ 
   return temp;
}