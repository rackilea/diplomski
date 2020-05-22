public class Solution<T extends GenericFilePOJO> {
    private InfoHolder infoHolder = new InfoHolder();

    @Bean
    public FlatFileItemReader<T> reader()
    {
        FlatFileItemReader<T> reader = new FlatFileItemReader<T>();
        reader.setLinesToSkip(1);

        reader.setLineMapper(new DefaultLineMapper() {
            {
                setLineTokenizer(infoHolder.getLineTokenizer());
                setFieldSetMapper(infoHolder.getFieldSetMapper());
            }
        });
        return reader;
    }

    private class InfoHolder {
        DelimitedLineTokenizer getLineTokenizer() {
            return <some already existent logic>;
        }

        FieldSetMapper<T> getFieldSetMapper() {
            if (some condition for specific file POJO 1){
                return new BeanWrapperFieldSetMapper<T>() {
                    {
                        setTargetType(FileSpecificPOJO_1.class);
                    }
                };
            } else if (some condition for specific file POJO 2){
                return new BeanWrapperFieldSetMapper<T>() {
                    {
                        setTargetType(FileSpecificPOJO_2.class);
                    }
                };
            }
        }
    }
}