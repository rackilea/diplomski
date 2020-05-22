package com.mydemo.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class Application extends WebMvcConfigurerAdapter
{

    @Bean
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver c = new InternalResourceViewResolver();
        c.setPrefix("/");
        c.setSuffix(".jsp");
        return c;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();

    }
}