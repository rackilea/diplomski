List<Peak> p1;
List<Peak> p2;

p1.sort((p1, p2) -> {
    int comp = Integer.compare(p1.getPeakMaxima(), p2.getPeakMaxima());
    return comp != 0 ? comp : p1.getRname().compareTo(p2.getRname());
});

// and also sort the second list