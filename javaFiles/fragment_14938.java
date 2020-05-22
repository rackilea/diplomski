vectors = space.getVectorsAsArray(); # Java array (MxN)
wvl = space.getAverageWavelengths(); # Java array (N)

wavelengths = list(wvl)

import matplotlib.pyplot as mp
mp.hold
for i, dataset in enumerate(vectors):
    mp.plot(wavelengths, list(dataset))