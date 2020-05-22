int[] inputs = new int[3];
...
...   
sc = new Scanner(System.in);    
// Providing instructions to the user    
System.out.println("Enter the red, green, and blue intensity for the LED (values from 0 to 255)");    
// Reading in the three integers    
System.out.print("Red: <=200 ");    
int red = sc.nextInt();    
inputs[0] = red;
System.out.print("Green: <=250 ");    
int green = sc.nextInt();    
inputs[1] = green;    
System.out.print("Blue: <=250 ");    
int blue = sc.nextInt();      
inputs[2] = blue;