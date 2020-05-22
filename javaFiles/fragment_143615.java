@Test (expected = RestClientException.class)
        public void myTest() {
            Mockito.when(
                    restTemplate.postForEntity(Mockito.anyString(), Mockito.any(SomeBean.class), Mockito.any()))
                    .thenThrow(new RestClientException(null));

            service.postMessage(); // something like that needed here
        }