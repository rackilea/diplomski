import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.driver.ParameterConversionMode;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestConfiguration
public class SkillRatingRepositoryTest {

    @Autowired
    private SkillRatingRepository skillRatingRepository;

    @Autowired
    private Session session;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Test
    public void retrievalOfSkillsShouldWork() {
        Skill s = Skill.builder().name("Java")
            .description("The Number one programming language everyone loves and hates").build();

        new TransactionTemplate(transactionManager).execute(t -> {
            session.purgeDatabase();
            return null;
        });

        Person ms = Person.builder()
            .firstName("Michael")
            .lastName("Simons")
            .build();
        Person gm = Person.builder()
            .firstName("Gerrit")
            .lastName("M")
            .build();
        SkillRating r1 = SkillRating
            .builder().person(ms)
            .skill(s).measurementDate(LocalDate.now()).score(23).build();
        SkillRating r2 = SkillRating
            .builder().person(gm)
            .skill(s).measurementDate(LocalDate.now()).score(42).build();

        skillRatingRepository.saveAll(Arrays.asList(r1, r2));

        List<SkillRating> skillRatings =
            skillRatingRepository.findAllByPerson(gm);
        assertThat(skillRatings).hasSize(1);
    }

    @TestConfiguration
    static class Config {

        @Bean
        public org.neo4j.ogm.config.Configuration configuration() {
            Configuration.Builder builder = new org.neo4j.ogm.config.Configuration.Builder();
            builder.uri("bolt://localhost:7687");
            builder.credentials("neo4j", "secret");
            builder.withCustomProperty(ParameterConversionMode.CONFIG_PARAMETER_CONVERSION_MODE,
                ParameterConversionMode.CONVERT_NON_NATIVE_ONLY);
            return builder.build();
        }
    }
}