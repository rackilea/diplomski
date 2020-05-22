import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Machine {
    int getUnitId() { return 0; }
}

class PlantType { }
class PlantStatus { }
class PlantOperatorStatus { }
class Alarm { }
class Doser extends Machine { }
class Extruder extends Machine { }
class Blower extends Machine { }
class Die extends Machine { }
class HaulOff extends Machine { }
class Winder extends Machine { }
class FilmMeasurer extends Machine { }
class AirRing extends Machine { }

interface AlarmsListener<M, A> { }
class ListenableObject<T> { }

interface MachineMorphology<M extends Machine> {

    Class<? extends M> getClazz();
}

final class ExtrusionMachinesMorphology<M extends Machine> implements MachineMorphology<M> {
    public static final ExtrusionMachinesMorphology<Doser> DOSER = new ExtrusionMachinesMorphology<>(Doser.class);
    public static final ExtrusionMachinesMorphology<Extruder> EXTRUDER = new ExtrusionMachinesMorphology<>(Extruder.class);
    public static final ExtrusionMachinesMorphology<Blower> BLOWER = new ExtrusionMachinesMorphology<>(Blower.class);
    public static final ExtrusionMachinesMorphology<Die> DIE = new ExtrusionMachinesMorphology<>(Die.class);
    public static final ExtrusionMachinesMorphology<HaulOff> HAULOFF = new ExtrusionMachinesMorphology<>(HaulOff.class);
    public static final ExtrusionMachinesMorphology<Winder> WINDER = new ExtrusionMachinesMorphology<>(Winder.class);
    public static final ExtrusionMachinesMorphology<FilmMeasurer> MEASUSER = new ExtrusionMachinesMorphology<>(FilmMeasurer.class);
    public static final ExtrusionMachinesMorphology<AirRing> AIR_RING = new ExtrusionMachinesMorphology<>(AirRing.class);
    public static final ExtrusionMachinesMorphology<?> GEC = null;
    public static final ExtrusionMachinesMorphology<?> UNDEFINED = null;

    private final Class<M> clazz;

    public ExtrusionMachinesMorphology(Class<M> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends M> getClazz() {
        return clazz;
    }
}

public abstract class AbstractPlant<T extends PlantType, S extends PlantStatus, O extends PlantOperatorStatus, A extends Alarm> 
    extends ListenableObject<AlarmsListener<Machine, A>> {

    private volatile HashMap<MachineMorphology<? extends Machine>, List<? extends Machine>> machines = new HashMap<>();

    public synchronized <M extends Machine> M getMachine(MachineMorphology<M> morphology,
                                                         int unitId) {
        return getMachineByUnitId(getMachinesByMorphology(morphology), unitId);
    }

    public synchronized <M extends Machine> M getMachineByUnitId(List<M> machines, int unitId) {
        return machines.stream().filter(machine -> machine.getUnitId() == unitId).findFirst().orElse(null);
    }

    public synchronized <M extends Machine> List<M> getMachinesByMorphology(MachineMorphology<M> morphology) {
        Class<? extends M> machineType = morphology.getClazz();
        return machines.get(morphology).stream().map(machineType::cast).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        AbstractPlant<PlantType, PlantStatus, PlantOperatorStatus, Alarm> plant =
            new AbstractPlant<PlantType, PlantStatus, PlantOperatorStatus, Alarm>() { };

        Doser doser = plant.getMachine(ExtrusionMachinesMorphology.DOSER, 1);
    }
}