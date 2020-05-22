class C {
    class Feature {
        String ext

        Feature(String ext) {
            this.ext = ext
        }

        String toString() {
            ext
        }        
    }

    def n() {
        new Feature('nnnn')
    }
}

class C2 extends C {
    def m() {
        new Feature(this, 'mmmm')
    }
}

def c = new C()
println c.n()

def c2 = new C2()
println c2.m()