public static void main(String[] args) {
        StringBuilder []sb=new StringBuilder[5];
        for(int i=0;i<5;i++){
          sb[i]=new StringBuilder("98345834"+i);
          sb[i].insert((sb[i].length()-4), '/');
          System.out.println(sb[i]);
        }
    }