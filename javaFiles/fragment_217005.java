import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VisitorTest {
   public static void main(String[] args) {
      Random random = new Random();
      List<Section> sectionList = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
         Section section = random.nextBoolean() ? new ConcreteSection() : new ConcreteMapSection();
         sectionList.add(section);
      }

      SectionVisitor visitor = new ConcreteSectionVisitor();
      for (Section section : sectionList) {
         section.accept(visitor);
      }
   }
}

interface Section {
   void someMethod();
   void accept(SectionVisitor visitor);
}

interface MapSection extends Section {
   void additionalProcessingMethod();
}

interface SectionVisitor {
   void visit(Section section);
   void visit(MapSection mapSection);
}

class ConcreteSection implements Section {

   @Override
   public void someMethod() {
      System.out.println("someMethod in ConcreteSection");
   }

   @Override
   public void accept(SectionVisitor visitor) {
      visitor.visit(this);
   }

}

class ConcreteMapSection implements MapSection {

   @Override
   public void someMethod() {
      System.out.println("someMethod in ConcreteMapSection");
   }

   @Override
   public void additionalProcessingMethod() {
      System.out.println("additionalProcessingMethod in ConcreteMapSection");
   }

   @Override
   public void accept(SectionVisitor visitor) {
      visitor.visit(this);
   }

}

class ConcreteSectionVisitor implements SectionVisitor {

   @Override
   public void visit(Section section) {
      section.someMethod();
   }

   @Override
   public void visit(MapSection mapSection) {
      mapSection.someMethod();
      mapSection.additionalProcessingMethod();
   }

}