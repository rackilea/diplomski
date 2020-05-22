statement returns [Leaf node]
    :  assignment     {node = $assignment.node;}
    |  write          {node = $write.node;}
    |  writeln        {node = $writeln.node;}
    |  readBool       {node = $readBool.node;}
    |  readInt        {node = $readInt.node;}
    ;