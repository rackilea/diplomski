public class DependencyConverter implements Converter {
        @Autowired
        private CategoriaRepository repository;

        @Override
        public Categoria convert(String id) {
            return repository.findById(id);
        }
    }