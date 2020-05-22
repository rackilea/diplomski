Rectangle[] arr = new Rectangle[10];

for(int i = 0; i < 10; i++)
{
 Rectangle r = new Rectangle();
 r.setWidth((Math.random()*40)+10); 
 r.setHeight((Math.random()*40)+10);

 arr[i] = r;
}