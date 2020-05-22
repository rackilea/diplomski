int foo(bar){
     int to_the_next;

      if (go_recursive){
            to_the_next = foo(whisky_bar);

            if (to_the_next ==DIE) return DIE;
      }

      if (something_unexpected_happened) return DIE;

      process;//may include some other recursive calls, etc etc
}