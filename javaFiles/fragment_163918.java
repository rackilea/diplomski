import java.util.*;
import java.util.stream.Collectors;
import org.gep4j.*;
import org.gep4j.math.Multiply;
import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.*;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.TargetFitness;

public class TestMainProg {
   private static final double NUM = 36.0;
   private static final int RUN = 50;

   public void go() {
      KarvaEvaluator karvaEvaluator = new KarvaEvaluator();

      GeneFactory factory = new GeneFactory( Arrays.asList(
         new SimpleNodeFactory(new Multiply()),
         new IntegerConstantFactory( 2, (int)(NUM/2) )
      ), 3 );

      EvolutionaryOperator<INode[]> pipeline = new EvolutionPipeline<>( Arrays.asList(
         new MutationOperator<>(factory, new Probability(0.5d))
      ) );

      FitnessEvaluator<INode[]> evaluator = new FitnessEvaluator<INode[]>() {
         @Override public double getFitness(INode[] candidate, List<? extends INode[]> population) {
            return Math.abs( NUM - (Double) karvaEvaluator.evaluate(candidate) );
         }
         @Override public boolean isNatural() {
            return false;
         }
      };

      EvolutionEngine<INode[]> engine = new GenerationalEvolutionEngine<>(factory, pipeline, evaluator,
            new RouletteWheelSelection(), new MersenneTwisterRNG());

      Set<String> results = new HashSet<>();
      for ( int i = 0 ; i < RUN ; i ++ ) {
         List<EvaluatedCandidate<INode[]>> finalPopulation =
            engine.evolvePopulation(100,10, new TargetFitness(0, false));
         // Add all survivors to result
         finalPopulation.stream().filter( e -> e.getFitness() == 0 )
            .map( e -> karvaEvaluator.print( e.getCandidate() ) )
            .forEach( results::add );
      }
      new TreeSet( results ).stream().forEach( System.out::println );
   }

   public static final void main(String args[]) {
      new TestMainProg().go();
   }
}