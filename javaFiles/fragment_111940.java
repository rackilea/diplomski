public static void main(String args[]) { 
   // 2D matrix 
   Node arr[][]= new Node[11][11];
   int m = 11, n = 11; 

   int no=1;
   for(int i=0;i<m;i++){
       for(int j=0;j<n;j++){

         arr[i][j] = new Node();
         arr[i][j].no = no;
         arr[i][j].xpos = j;
         arr[i][j].ypos = i;
         no=no+1;
       }
   }

   for(int i=0; i<m; i++)
   {
     for(int j=0; j<n; j++)
     {
       arr[i][j].up    = (i>0)   ? arr[i-1][j] : null;
       arr[i][j].left  = (j>0)   ? arr[i][j-1] : null;
       arr[i][j].down  = (i+1<m) ? arr[i+1][j] : null;
       arr[i][j].right = (j+1<n) ? arr[i][j+1] : null;
     }
   }

   Node head = arr[0][0];
   display(head); 

   hunter(head,5,5);
   }
}