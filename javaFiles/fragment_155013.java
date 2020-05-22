@RestController
    @RequestMapping(value="/note")
    public class NoteController {

        @Autowired
        private NoteRepository noteRepository;

        @GetMapping(value="/debug")
        public List<Note> getNotes(){
            return noteRepository.findAll();
        }

    }