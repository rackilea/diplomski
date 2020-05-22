import groovy.transform.CompileStatic

@CompileStatic
int squarePlusOne(int num) {
   num * num + 1
}

assert squarePlusOne(3) == 10