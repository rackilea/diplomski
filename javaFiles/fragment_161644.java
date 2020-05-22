while (count < name.length())
{       
    int res = name.charAt(count);
    if (( res !='a')&&(res !='A')) {
      System.out.println(name.charAt(count));
    }
    count++;
}