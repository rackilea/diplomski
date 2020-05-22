import sun.jvm.hotspot.gc_implementation.g1.G1CollectedHeap;
import sun.jvm.hotspot.gc_implementation.g1.HeapRegionSetCount;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.tools.Tool;

public class HumongousRegionSet extends Tool {
    @Override
    public void run() {
        G1CollectedHeap heap = (G1CollectedHeap) VM.getVM().getUniverse().heap();
        HeapRegionSetCount count = heap.humongousSet().count();

        System.out.printf("%d humongous regions of total capacity %d MB\n",
                count.length(), count.capacity() >>> 20);
    }

    public static void main(String[] args) {
        new HumongousRegionSet().execute(args);
    }
}