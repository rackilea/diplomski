import groovy.transform.CompileStatic
import static JavaClass.processRendered

@CompileStatic
def test() {
  processRendered { Map<String, Object> map ->
    map.put("test", 1)
  }

  processRendered {
    it.put("test", 2)
  }
}

test()