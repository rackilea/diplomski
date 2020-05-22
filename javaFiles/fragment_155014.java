@Controller
    @RequestMapping(value="/note")
    public class NoteController {

        @Autowired
        private NoteRepository noteRepository;

        @GetMapping(value="/debug")
        public ResponseEntity<List<Note>> getNotes(){
             return new ResponseEntity<List<Note>>(noteRepository.findAll(),HttpStatus.OK);
        }

    }