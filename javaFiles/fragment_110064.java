for (LocusBeacon i : LocusData.locusBeacons) {
        beaconManager.startMonitoringBeaconsInRegion(new Region(i.getId(),
                Identifier.parse(i.getUUID()),
                Identifier.fromInt(Integer.parseInt(i.getMajor())),
                Identifier.fromInt(Integer.parseInt(i.getMinor()))));
}