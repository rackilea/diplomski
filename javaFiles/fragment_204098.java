import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@CrossOrigin()
@RestController
public class StudentController {
    StudentRepository studentService;

    public StudentController(StudentRepository studentService) {
        this.studentService = studentService;
    }

    @GetMapping("student/filter")
    public ResponseEntity<Page<Student>> getFilteredList(@QuerydslPredicate(root = Student.class) Predicate predicate, Pageable pageable) {
        System.out.println("Something");

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("requestedBy", "Shamin Asfaq");

        Page<Student> studentList = studentService.findAll(predicate, pageable);
        return new ResponseEntity<>(studentList, multiValueMap, HttpStatus.OK);
    }
}