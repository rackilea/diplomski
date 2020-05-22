this.m_ShapeRenderer.begin(ShapeType.Rectangle);
this.m_ShapeRenderer.setColor(1.f, 1.f, 1.f, 1.f);
this.m_ShapeRenderer.identity();
this.m_ShapeRenderer.translate(20.f, 10.f, 0.f);
this.m_ShapeRenderer.rotate(0.f, 0.f, 1.f, 45.f);
this.m_ShapeRenderer.rect(x, y, 40.f, 20.f);
this.m_ShapeRenderer.end();