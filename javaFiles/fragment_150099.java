package ActionMathML;

import java.io.File;
import javax.xml.bind.*;

public class UnmarshalDemo {

    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance("ActionMathML");

        Unmarshaller unmarshaller = context.createUnmarshaller();
        File xml = new File("src/ActionMathML/input.xml");
        JAXBElement<TraitementDTO> jaxbElement = (JAXBElement<TraitementDTO>) unmarshaller.unmarshal(xml);

        TraitementDTO traitementDTO = jaxbElement.getValue();
        System.out.println(traitementDTO.getCodeTraitement());

        if(traitementDTO instanceof Utilisateur) {
            Utilisateur utilisateur = (Utilisateur) traitementDTO;
            System.out.println(utilisateur.getNomUtilisateur());
            System.out.println(utilisateur.getPassUtilisateur());
        }
    }

}