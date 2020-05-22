import java.util.List
import java.util.Map
...
Yaml yaml = new Yaml();
List load = yaml.loadAs("- text: Here is an object with some data that will allow an image to be generated\n  image: &FirstIm\n    imageType: ABC\n    otherTypE: CB\n- text: Later on, lets show you the same image again!\n  image: *FirstIm", List.class);
assertSame(((Map)load.get(0)).get("image"), ((Map)load.get(1)).get("image"));