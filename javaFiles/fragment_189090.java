public class PublicOpinionModifier implements Modifier {

    public void modify(Stock target, float modifier) {
        target.setPublicOpinion(target.getPublicOpinion() + modifier);  
    }

}