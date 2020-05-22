VehicleRoutingTransportCostsMatrix.Builder vrtcMatrix;
VehicleRoutingTransportCostsMatrix costsMatrix;
vrtcMatrix.addTransportDistance(String.valueOf(fromId), String.valueOf(toId),
                                (double) distance.inMeters);
vrtcMatrix.addTransportTime(String.valueOf(fromId), String.valueOf(toId),
                                (double) duration.inSeconds);
costsMatrix = vrtcMatrix.build();