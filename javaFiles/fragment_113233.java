@Test
public void testEnumCompletude() {
    for (BusinessCriticality c : BusinessCriticality.values()) {
        for (EmergencyLevel e : EmergencyLevel.values()) {
            assertNotNull(String.format("%s/%s combination was forgotten", c, e), 
                EmergencyPriority.of(c, e));
        }
    }
}