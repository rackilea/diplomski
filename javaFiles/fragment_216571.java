%module example

%typemap(memberin) char *buffer {
  // Keep whatever other bits of the mechanics you care about 
  if ($1) free($1);
  if ($input) {
    $1 = malloc(strlen($input)+1);
    customized_strcpy($1, $input);
  } else {
    $1 = 0;
  }
}

%inline %{
typedef struct Test {
  char *buffer;
} Test;
%}