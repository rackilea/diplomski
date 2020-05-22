@Test
public void formula() throws Exception
{
    float _height = 180;
    float _waist = 90;
    float _neck = 50;
    double fat = 495/(1.0324f-(0.19077f*(Math.log10(_waist-_neck)))+0.15456f*(Math.log10(_height)))-450;
    System.out.println(fat);
}