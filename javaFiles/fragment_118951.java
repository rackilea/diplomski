import java.lang.StringBuilder;

    StringBuilder sb = new StringBuilder();
    sb.append("Billy "); 
    sb.append("Scranner"); 
    System.out.println(sb); 

    sb.insert(5, " D");
    System.out.println(sb); 
    sb.delete(5, 7);

    sb.reverse(); 

    System.out.println(sb);