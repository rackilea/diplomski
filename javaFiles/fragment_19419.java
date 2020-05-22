package lombok;

        @Getter
        @Setter
        @SuperBuilder
        public class BaseVO {


            private String s1;
            private String s2;
            private String s3;
            private String s4;
            private String s5;
            private String s6;
            private String s7;
            private String s8;
            private String s9;

        }


        package lombok;

        @Getter
        @Setter
        @SuperBuilder
        public class VO1 extends BaseVO{

            private String vo1Specific;
        }


        package lombok;

        @Getter
        @Setter
        @SuperBuilder
        public class VO2 extends BaseVO {

            private String vo2Specific;
        }

        package lombok;

        @Builder
        @ToString
        public class DomainEntity {

            private String s1;
            private String s2;
            private String s3;
            private String s4;
            private String s5;
            private String s6;
            private String s7;
            private String s8;
            private String s9;
            private String specific;

        }


package lombok;

import lombok.DomainEntity.DomainEntityBuilder;

public class Converter {

    public static <T extends BaseVO> DomainEntity fromVO(T basevo) {

        DomainEntityBuilder builder = DomainEntity.builder();
        builder.s1(basevo.getS1()).s2(basevo.getS2()).s3(basevo.getS3());

        if (basevo instanceof VO1) {
            VO1 vo1 = (VO1) basevo;
            builder.specific(vo1.getVo1Specific());

        }

        if (basevo instanceof VO2) {
            VO2 vo1 = (VO2) basevo;
            builder.specific(vo1.getVo2Specific());

        }

        return builder.build();

    }

}

        package lombok;

        public class App {

            public static void main(String[] args) {

            VO1 vo1 = VO1.builder().s1("VO1S1").vo1Specific("VO1 specific property").build();

            VO2 vo2 = VO2.builder().s1("VO2S1").vo2Specific("VO2 specific property").build();

            DomainEntity d1 = Converter.<VO1>fromVO(vo1);
            System.out.println(" d1 " + d1);
            DomainEntity d2 = Converter.<VO2>fromVO(vo2);

            System.out.println(" d2 " + d2);

            }

        }