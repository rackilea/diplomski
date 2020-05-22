input_string = Stringify(json)
result = 0;
for(each chunk of size K from input_string){
    result = result XOR chunk;
}
return result