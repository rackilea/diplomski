@Bean
@StepScope
public FlatFileItemReader<PersonneDTO> reader(@Value("#{jobExecutionContext['personneFile']}") String pathToDFile) {
     FlatFileItemReader<PersonneDTO> reader = new FlatFileItemReader<PersonneDTO>();
     reader.setResource(new FileSystemResource(pathToDFile));
     reader.setLineMapper(new DefaultLineMapper<PersonneDTO>() {{
        setLineTokenizer(new DelimitedLineTokenizer() {{
            setNames(new String[] {"nom", "prenom" ,"dateNaissance" });
        }});
        setFieldSetMapper(new BeanWrapperFieldSetMapper<PersonneDTO>() {{
            setTargetType(PersonneDTO.class);
        }});
    }});
    return reader;
  }