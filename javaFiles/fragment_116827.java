DogRepository mockRepo = mock(DogRepository.class);

Dog fido = new Dog("Fido");
Dog brutus = new Dog("Brutus");
when(mockRepo.findAll()).thenReturn(Arrays.asList(fido, brutus));

DogService service = new DogService(mockRepo);
List<Dog> result = service.getAllDogs();
assertEquals(Arrays.asList(fido, brutus), result);