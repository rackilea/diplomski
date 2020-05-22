package batch_config;
...
@EnableBatchProcessing
@ComponentScan(basePackageClasses = MyBatchConfigurer.class)
public class MyBatchConfig {
    ...
}