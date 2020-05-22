String mainstr = "[[data link control], [communication, []], [computer, [applications     of computer, number of computer]], [world wide web], [lesson, [covered in lesson]], [access to remote], [marketing and sale], [electronic fund transfer], [network, [network of network, wide area network, communication network, computer network, [area network, [local area network, metropolitan area network]]]]]";
  String search = "communication network";
  int start = mainstr.indexOf(search);
  if (start != -1)
  {
     int end = start + search.length();
     int count = 0;
     int pos = end;
     if (mainstr.charAt(end+2) == '[')
     {
        while (count != -1)
           if (mainstr.charAt(++pos) == ']')
              count--;
           else if (mainstr.charAt(++pos) == '[')
              count++;
        System.out.println("Ancestors = " + mainstr.substring(end+2, pos-1));
     }
     count = 0;
     pos = start;
     int lastComma = -1;
     while (count != 2)
        switch (mainstr.charAt(--pos))
        {
           case ']': count--; break;
           case '[': count++; break;
           case ',': lastComma = pos;
        }
     System.out.println("Parent = " + mainstr.substring(pos+1, lastComma));
  }