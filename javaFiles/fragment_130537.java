@Test
public void deveExcluirPorId() throws QualityException {
    usuarioService.excluir(ID);
    verify(usuariosRepositoryMock, times(1)).delete(ID);
    verifyNoMoreInteractions(usuariosRepositoryMock);
}