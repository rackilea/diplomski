import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

....

String[] strArray = new String[] {"foo", "bar"};
List<String[]> data = new ArrayList<>();
data.add(strArray);

Page<String[]> page = new PageImpl<>(data);