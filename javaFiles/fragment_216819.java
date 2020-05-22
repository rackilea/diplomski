loop 
  select();
  if readable
     bytes = read()
     buffer.append(bytes)
     while( buffer has EOT at position i)
       msg = buffer[0-i]
       left shift buffer by i